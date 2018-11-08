using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LogLog_Program
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
                lglg = Lg(lglg);
                Console.WriteLine("LogLog({0}) = {1}.", n, lglg);
            }
        }
         static int Lg(long n)
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

