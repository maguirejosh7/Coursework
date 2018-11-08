/* Porgram 2
 * Code started by Profesor Plantinga
 * Finished by Nick VanderKolk
 * CS 212
 * 10/11/13
 */




using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.IO;
using System.Collections;

namespace BabbleSample
{
    /// Babble framework
    /// Starter code for CS212 Babble assignment
    public partial class MainWindow : Window
    {
        private string input;               // input file
        private string[] words;             // input file broken into array of words
        private int wordCount = 200;        // number of words to babble
        private Dictionary<string, ArrayList> hashTable = new Dictionary<string, ArrayList>(); //A dictionary of arraylists with a string as the key
        public MainWindow()
        {
            InitializeComponent();
        }

        private void loadButton_Click(object sender, RoutedEventArgs e)
        {
            Microsoft.Win32.OpenFileDialog ofd = new Microsoft.Win32.OpenFileDialog();
            ofd.FileName = "Sample"; // Default file name
            ofd.DefaultExt = ".txt"; // Default file extension
            ofd.Filter = "Text documents (.txt)|*.txt"; // Filter files by extension

            // Show open file dialog box
            if ((bool)ofd.ShowDialog())
            {
                textBlock1.Text = "Loading file " + ofd.FileName + "\n";
                input = System.IO.File.ReadAllText(ofd.FileName);  // read file
                words = Regex.Split(input, @"\s+");       // split into array of words
            }
        }

        private void analyzeInput(int order)
        {
            if (order > 0)
            {
                MessageBox.Show("Analyzing at order: " + order);
                for (int i = 0; i < words.Length - 2; i++) //hash all words except the last one (which has no next word to hash)
                {
                    if (!hashTable.ContainsKey(words[i]))
                    {
                        hashTable.Add(words[i], new ArrayList());
                    }
                    hashTable[words[i]].Add(words[i + 1]);
                }
                if (!hashTable.ContainsKey(words[words.Length - 1])) //checks if hashtable contains hash of last word.
                {
                    hashTable.Add(words[words.Length - 1], new ArrayList());  //.. if it doesn't contain, then it makes new arraylist..
                    hashTable[words[words.Length - 1]].Add(words[0]);       // .. and adds the first word to that list.
                }
                //

            }
        }

        private void babbleButton_Click(object sender, RoutedEventArgs e)
        {

            textBlock1.Text = "";
            Random r = new Random();
            ArrayList inputWords = new ArrayList(); //temp array to pull out an array at a key location
            textBlock1.Text += words[0];    //display first word
            string currentWord = words[0]; //currentWord is a variable for the word we care currently babbling off of.
            string tempWord;
            for (int i = 0; i < Math.Min(wordCount, words.Length) - 1; i++)
            {
                inputWords = hashTable[currentWord]; //the arraylist inputWords is set to the array in the hashtable at currentWord
                tempWord = "" + inputWords[r.Next(0, inputWords.Count - 1)];   //then a temperary word is choosen from the list of inputwords and stored in tempWord

                textBlock1.Text += " " + tempWord;//that tempWord is outputted 
                currentWord = tempWord;
            }
        }

        private void orderComboBox_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            hashTable.Clear();
            analyzeInput(orderComboBox.SelectedIndex);
        }
    }
}

