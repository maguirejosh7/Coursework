using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
namespace Fib
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("The Log of a log!");
            while (true)
            {
                Console.Write("\nEnter the Number you wish to compute: ");
                int n= int.Parse(Console.ReadLine());

                int lglg = Lg(n);
                lglg = lglg(lglg);
                Console.WriteLine("LogLog({0}) = {1}.", n, lglg);
            }
        }
         int Lg(long n)
        {
            int counter;
            counter = 0;
            
            while (n > 1)
            {
                n = n / 2;
                counter++;

            }
            return counter;
        }
    }
}
