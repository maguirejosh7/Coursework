using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.IO;

namespace Bingo
{
    class Program
    {
        private static RelationshipGraph rg;

        // Read RelationshipGraph whose filename is passed in as a parameter.
        // Build a RelationshipGraph in RelationshipGraph rg
        private static void ReadRelationshipGraph(string filename)
        {
            rg = new RelationshipGraph();                           // create a new RelationshipGraph object

            string name = "";                                       // name of person currently being read
            int numPeople = 0;
            string[] values;
            Console.Write("Reading file " + filename + "\n");
            try
            {
                string input = System.IO.File.ReadAllText(filename);// read file
                input = input.Replace("\r", ";");                   // get rid of nasty carriage returns 
                input = input.Replace("\n", ";");                   // get rid of nasty new lines
                string[] inputItems = Regex.Split(input, @";\s*");  // parse out the relationships (separated by ;)
                foreach (string item in inputItems)
                {
                    if (item.Length > 2)                            // don't bother with empty relationships
                    {
                        values = Regex.Split(item, @"\s*:\s*");     // parse out relationship:name
                        if (values[0] == "name")                    // name:[personname] indicates start of new person
                        {
                            name = values[1];                       // remember name for future relationships
                            rg.AddNode(name);                       // create the node
                            numPeople++;
                        }
                        else
                        {
                            rg.AddEdge(name, values[1], values[0]); // add relationship (name1, name2, relationship)

                            // handle symmetric relationships -- add the other way
                            if (values[0] == "spouse" || values[0] == "friend")
                                rg.AddEdge(values[1], name, values[0]);

                            // for parent relationships add child as well
                            else if (values[0] == "parent")
                                rg.AddEdge(values[1], name, "child");
                            else if (values[0] == "child")
                                rg.AddEdge(values[1], name, "parent");
                        }
                    }
                }
            }
            catch (Exception e)
            {
                Console.Write("Unable to read file {0}: {1}\n", filename, e.ToString());
            }
            Console.WriteLine(numPeople + " people read");
        }

        // Show the relationships a person is involved in
        private static void ShowPerson(string name)
        {
            GraphNode n = rg.GetNode(name);
            if (n != null)
                Console.Write(n.ToString());
            else
                Console.WriteLine("{0} not found", name);
        }

        // Show a person's friends
        private static void ShowFriends(string name)
        {
            GraphNode n = rg.GetNode(name);
            if (n != null)
            {
                Console.Write("{0}'s friends: ", name);
                List<GraphEdge> friendEdges = n.GetEdges("friend");
                foreach (GraphEdge e in friendEdges)
                {
                    Console.Write("{0} ", e.To());
                }
                Console.WriteLine();
            }
            else
                Console.WriteLine("{0} not found", name);
        }

        //Shows all persons without parents
        private static void Orphans()
        {
            foreach (GraphNode n in rg.nodes)//for each node,
            {
                List<GraphEdge> edgeList = n.GetEdges("parent");//returns edge list of matching labels
                if (edgeList.Count < 1)                         //if that list is less than 0,
                    Console.WriteLine(n.Name());                //person is orphan, print their name.
            }
        }

        /// <summary>
        ///shows all of a persons descendants, depth first order right now.... 
        /// </summary>
        /// <param name="name"></param> name of person of whom descendants will be found
        private static void Descendants(string name)
        {
            //start at name
            GraphNode n = rg.GetNode(name);
            //look for children edges
            List<GraphEdge> childEdges = n.GetEdges("child");
            foreach (GraphEdge e in childEdges)
            {
                //recurse through the other end of the child edge using To()
                Descendants(e.To());
            }
            Console.WriteLine(n.Name());     //prints the name of the first name, which it shouldn't
        }

        //bingo method stub
        private static void Bingo(string startName, string targetName)
        {

        }

        // accept, parse, and execute user commands
        private static void commandLoop()
        {
            string command = "";
            string[] commandWords;
            Console.Write("Welcome to Harry's Dutch Bingo Parlor!\n");

            while (command != "exit")
            {
                Console.Write("\nEnter a command: ");
                command = Console.ReadLine();
                commandWords = Regex.Split(command, @"\s+");        // split input into array of words
                command = commandWords[0];

                if (command == "exit")
                    ;                                               // do nothing

                // read a relationship graph from a file
                else if (command == "read" && commandWords.Length > 1)
                    ReadRelationshipGraph(commandWords[1]);

                // show information for one person
                else if (command == "show" && commandWords.Length > 1)
                    ShowPerson(commandWords[1]);

                else if (command == "friends" && commandWords.Length > 1)
                    ShowFriends(commandWords[1]);

                // dump command prints out the graph
                else if (command == "dump")
                    rg.dump();

                //show people without parents
                else if (command == "orphans")
                    Orphans();

                //shows descendants of person
                else if (command == "descendants" && commandWords.Length > 1)
                    Descendants(commandWords[1]);

                else if (command == "bingo" && commandWords.Length > 2)
                    Bingo(commandWords[1], commandWords[2]);
                // illegal command
                else
                    Console.Write("\nLegal commands: read [filename], dump, show [personname],\n  friends [personname], orphans, descendants [personname], bingo [name] [name], exit\n");
            }
        }

 

        static void Main(string[] args)
        {
            commandLoop();
        }
    }
}