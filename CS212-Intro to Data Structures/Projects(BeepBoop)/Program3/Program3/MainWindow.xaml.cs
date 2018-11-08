/*
 * Program 3- refined by Joshua Maguire for CS212 on 10/30/2013.
 * Draws a tree looking thing with random birds, randomish colored berries, and a randomly colored vase.
 * The top slider controles the size of the lines, the middle controlles how many children each branch has, and the last 
 *      controlles the lean of the tree.
 *
 */



using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Media.Animation;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Program3
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }


        private void Window_Loaded(object sender, RoutedEventArgs e)
        {
            Fern f = new Fern(sizeSlider.Value, reduxSlider.Value, biasSlider.Value, canvas);
        }


        private void button1_Click(object sender, RoutedEventArgs e)
        {
            Fern f = new Fern(sizeSlider.Value, reduxSlider.Value, biasSlider.Value, canvas);
        }
    }




    class Fern
    {
        private static int BERRYMIN = 10;
        private static int TENDRILS = 7;
        private static int TENDRILMIN = 10;
        private static double DELTATHETA = 0.1;
        private static double SEGLENGTH = 3.0;
        private static Random random = new Random();


        /* 
         * Fern constructor erases screen and draws a fern
         * 
         * Size: number of 3-pixel segments of tendrils     10-240
         * Redux: how much smaller children clusters are compared to parents. 1.5-5
         * Turnbias: how likely to turn right vs. left (0=always left, 0.5 = 50/50, 1.0 = always right)
         * canvas: the canvas that the fern will be drawn on
         */
        public Fern(double size, double redux, double turnbias, Canvas canvas)
        {
            canvas.Children.Clear();                                // delete old canvas contents
            // draw a new fern at the center of the canvas with given parameters
            polygon(240, 470, 220, 400, 420, 400, 400, 470, canvas); //flowerpot
            cluster(((int)(canvas.Width / 2)), (400), size, redux, turnbias, canvas);

        }


        /*
         * cluster draws a cluster at the given location and then draws a bunch of tendrils out in 
         * regularly-spaced directions out of the cluster.
         */
        private void cluster(int x, int y, double size, double redux, double turnbias, Canvas canvas)
        {
            for (int i = 0; i < TENDRILS; i++)
            {
                // compute the angle of the outgoing tendril
                double theta = (i * Math.PI / TENDRILS) + 2; //tendrils won't go negitive directions with +2 instead of *2 (compared to old code)
                tendril(x, y, size, redux, turnbias, theta, canvas);
                if (size > BERRYMIN)
                    berry(x, y, 4, canvas);
            }
        }

        /*
         * tendril draws a tendril (a randomly-wavy line) in the given direction, for the given length, 
         * and draws a cluster at the other end if the line is big enough.
         */
        private void tendril(int x1, int y1, double size, double redux, double turnbias, double direction, Canvas canvas)
        {
            int x2 = x1, y2 = y1;

            for (int i = 0; i < size; i++)
            {
                direction += (random.NextDouble() > turnbias) ? -1 * DELTATHETA : DELTATHETA;
                x1 = x2; y1 = y2;
                x2 = x1 + (int)(SEGLENGTH * Math.Sin(direction));
                y2 = y1 + (int)(SEGLENGTH * Math.Cos(direction));
                byte red = (byte)(100 + size / 2);
                byte green = (byte)(220 - size / 3);
                line(x1, y1, x2, y2, red, green, 0, 1 + size / 80, canvas);

            }
            if (size > TENDRILMIN)
                cluster(x2, y2, size / redux, redux, turnbias, canvas);
        }
        /// <summary>
        /// Draws a blue bird with 2 eyes and a beak.
        /// </summary>
        /// <param name="x1"></param> X coordinate of current place on a line where bird should be drawn.
        /// <param name="y1"></param> X=Y """"""""""""""""""""""""""""""""""""""""""""""""""""""""""""".
        /// <param name="canvas"></param> Current canvas
        private void bird(int x1, int y1, Canvas canvas)
        {
            Ellipse myEllipse = new Ellipse();  //body
            SolidColorBrush mySolidColorBrush = new SolidColorBrush();
            mySolidColorBrush.Color = Color.FromArgb(255, 0, 137, 255);
            myEllipse.Fill = mySolidColorBrush;
            myEllipse.StrokeThickness = 1;
            myEllipse.Stroke = mySolidColorBrush;
            myEllipse.HorizontalAlignment = HorizontalAlignment.Center;
            myEllipse.VerticalAlignment = VerticalAlignment.Center;
            myEllipse.Width = 2 * 9;
            myEllipse.Height = 2 * 9;
            myEllipse.SetCenter(x1, y1);
            canvas.Children.Add(myEllipse);
            Ellipse myEye1 = new Ellipse();
            mySolidColorBrush = Brushes.Black;  //eyes
            myEye1.Fill = mySolidColorBrush;
            myEye1.Stroke = mySolidColorBrush;
            myEye1.Width = 3;
            myEye1.Height = 4;
            myEye1.SetCenter(x1 - 2, y1 - 4);
            myEye1.HorizontalAlignment = HorizontalAlignment.Center;
            myEye1.VerticalAlignment = VerticalAlignment.Center;
            canvas.Children.Add(myEye1);
            Ellipse myEye2 = new Ellipse();
            myEye2.Fill = mySolidColorBrush;
            myEye2.Stroke = mySolidColorBrush;
            myEye2.Width = 3;
            myEye2.Height = 4;
            myEye2.HorizontalAlignment = HorizontalAlignment.Center;
            myEye2.VerticalAlignment = VerticalAlignment.Center;
            myEye2.SetCenter(x1 + 2, y1 - 4);
            canvas.Children.Add(myEye2);
            Polygon myBeak = new Polygon();         //beak
            mySolidColorBrush = Brushes.OrangeRed;
            myBeak.Fill = mySolidColorBrush;
            myBeak.Stroke = mySolidColorBrush;
            myBeak.HorizontalAlignment = HorizontalAlignment.Center;
            myBeak.VerticalAlignment = VerticalAlignment.Center;
            System.Windows.Point Point1 = new System.Windows.Point(x1 - 4, y1);
            System.Windows.Point Point2 = new System.Windows.Point(x1 + 4, y1);
            System.Windows.Point Point3 = new System.Windows.Point(x1, y1 + 4);
            PointCollection myPointCollection = new PointCollection();
            myPointCollection.Add(Point1);
            myPointCollection.Add(Point2);
            myPointCollection.Add(Point3);
            myBeak.Points = myPointCollection;
            canvas.Children.Add(myBeak);
        }
        /*
         * draw a varied color red circle centered at (x,y), radius radius onto canvas
         */
        private void berry(int x, int y, double radius, Canvas canvas)
        {
            Ellipse myEllipse = new Ellipse();
            SolidColorBrush mySolidColorBrush = new SolidColorBrush();
            mySolidColorBrush.Color = Color.FromArgb(255, (byte)random.Next(254), 0, 0); //random used here
            myEllipse.Fill = mySolidColorBrush;
            myEllipse.StrokeThickness = 1;
            myEllipse.Stroke = mySolidColorBrush;
            myEllipse.HorizontalAlignment = HorizontalAlignment.Center;
            myEllipse.VerticalAlignment = VerticalAlignment.Center;
            myEllipse.Width = 2 * radius;
            myEllipse.Height = 2 * radius;
            myEllipse.SetCenter(x, y);
            canvas.Children.Add(myEllipse);
        }

        /*
         * draw a line segment (x1,y1) to (x2,y2) with given color, thickness on canvas. Has a 1 in 900 chance to spawn a bird on the line.
         */
        private void line(int x1, int y1, int x2, int y2, byte r, byte g, byte b, double thickness, Canvas canvas)
        {
            Line myLine = new Line();
            SolidColorBrush mySolidColorBrush = new SolidColorBrush();
            mySolidColorBrush.Color = Color.FromArgb(255, r, g, b);
            myLine.X1 = x1;
            myLine.Y1 = y1;
            myLine.X2 = x2;
            myLine.Y2 = y2;
            if (random.Next(900) < 1) { bird(x1, y1, canvas); } //random used here
            myLine.Stroke = mySolidColorBrush;
            myLine.VerticalAlignment = VerticalAlignment.Center;
            myLine.HorizontalAlignment = HorizontalAlignment.Left;
            myLine.StrokeThickness = thickness;
            canvas.Children.Add(myLine);
        }
        /// <summary>
        /// Creates a polygon with 4 endpoints - a flowerpot. Color is random.
        /// </summary>
        /// <param name="x1"></param>x of point 1
        /// <param name="y1"></param>y of point 1
        /// <param name="x2"></param>x of point 2
        /// <param name="y2"></param>..
        /// <param name="x3"></param>..
        /// <param name="y3"></param>..
        /// <param name="x4"></param>..
        /// <param name="y4"></param>..
        /// <param name="canvas"></param> canvas were drawing on
        private void polygon(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, Canvas canvas)
        {
            Polygon myPolygon = new Polygon();
            SolidColorBrush mySolidColorBrush = new SolidColorBrush();
            mySolidColorBrush.Color = Color.FromArgb(255, (byte)random.Next(254), (byte)random.Next(254), (byte)random.Next(254));//random used here
            myPolygon.Stroke = mySolidColorBrush;
            myPolygon.Fill = mySolidColorBrush;
            myPolygon.HorizontalAlignment = HorizontalAlignment.Left;
            myPolygon.VerticalAlignment = VerticalAlignment.Center;
            System.Windows.Point Point1 = new System.Windows.Point(x1, y1);
            System.Windows.Point Point2 = new System.Windows.Point(x2, y2);
            System.Windows.Point Point3 = new System.Windows.Point(x3, y3);
            System.Windows.Point Point4 = new System.Windows.Point(x4, y4);
            PointCollection myPointCollection = new PointCollection();
            myPointCollection.Add(Point1);
            myPointCollection.Add(Point2);
            myPointCollection.Add(Point3);
            myPointCollection.Add(Point4);
            myPolygon.Points = myPointCollection;
            canvas.Children.Add(myPolygon);
        }
    }
}

/*
 * this class is needed to enable us to set the center for an ellipse (not built in?!)
 */
public static class EllipseX
{
    public static void SetCenter(this Ellipse ellipse, double X, double Y)
    {
        Canvas.SetTop(ellipse, Y - ellipse.Height / 2);
        Canvas.SetLeft(ellipse, X - ellipse.Width / 2);
    }
}
