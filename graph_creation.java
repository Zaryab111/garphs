import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack; 

public class graph_creation{
    private LinkedList<Integer>adjacency[];
    public graph_creation(int v)
    {
        adjacency = new LinkedList[v];
        for(int i=0 ; i<v ; i++)
        {
            adjacency[i] = new LinkedList<Integer>();
        }
    }

    public void addEdges(int s, int d)
     {
                adjacency[s].add(d);
                adjacency[d].add(s);
     }
        public static void main(String[] args)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the number of vertex and edges respectively: ");
            int v = sc.nextInt();
            int e = sc.nextInt();
            System.out.println("Enter the edges relations");
            graph_creation g = new graph_creation(v);
            for(int i = 0 ; i < e ; i++)
            {
                int s = sc.nextInt();
                int d = sc.nextInt();
                g.addEdges(s, d);
               
            }

        }
    }

