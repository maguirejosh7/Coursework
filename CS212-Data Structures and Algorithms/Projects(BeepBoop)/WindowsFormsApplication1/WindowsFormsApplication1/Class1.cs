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
Console.WriteLine("Fantastic Fib Finder!");
while (true)
{
Console.Write("\nEnter N: ");
long n = long.Parse(Console.ReadLine());
long fib = Fib(n);
Console.WriteLine("Fib({0}) = {1}.", n, fib);
}
}
static long Fib(long n)
{
if (n <= 2) 
return 1;
else 
return Fib(n - 1) + Fib(n - 2);
}
}
}