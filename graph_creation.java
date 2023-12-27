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

     public void bfs(int source)
     {
       boolean visitedNode[]= new boolean[adjacency.length];
       int parentNode[]= new int[adjacency.length];
       Queue<Integer> queue = new LinkedList<>();
       queue.add(source);
       visitedNode[source] = true;
       parentNode[source] = -1;
       while(!queue.isEmpty())
       {
        int p = queue.poll();
        System.out.println(p);
        for(int i:adjacency[p])
        {
            if(visitedNode[i] != true)
            {
                visitedNode[i] = true;
                queue.add(i);
                parentNode[i] =p; 
            }
        }
       }

     }
     public void dfs(int source)
     {
        boolean visitedNode[] = new boolean[adjacency.length];
        int parentNode[] = new int[adjacency.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        visitedNode[source] = true;
        parentNode[source] = -1;
        while(!stack.isEmpty())
        {
            int p = stack.pop();
            System.out.println(p);

            for(int i : adjacency[p])
            {
                if (visitedNode[i] != true)
                {
                    visitedNode[i] = true;
                    parentNode[i] = p;
                    stack.push(i);
                }
            }


        }


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
            System.out.println("bfs t");
        System.out.println("enter source");
        int source = sc.nextInt();
        g.bfs(source);

        System.out.println("dfs t");
        System.out.println("enter source");
        source = sc.nextInt();
        g.dfs(source);

        }
        
    
    }
