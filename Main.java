import java.util.*;
public class Main{
    public static class Edge{
        int src;
        int nbr;
        int wt;
        
        Edge(int src, int nbr, int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    
    public static void PrintAllPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String ans){
        if(src == dest){
            System.out.println(ans);
            return;
        }
        
        visited[src] = true;
        for(int i = 0; i < graph[src].size(); i++){
            Edge edge = graph[src].get(i);
            if(visited[edge.nbr] == false){
                PrintAllPath(graph, edge.nbr, dest, visited, ans + edge.nbr);
            }
        }
        visited[src] = false;
    }
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int vtces = scn.nextInt();
        int edges = scn.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for(int i = 0; i < vtces; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < edges; i++){
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();
            int wt = scn.nextInt();
            
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }
        
        int src = scn.nextInt();
        int dest = scn.nextInt();
        
        boolean[] visited = new boolean[vtces]; 
        PrintAllPath(graph, src, dest, visited, src + "");
        return;
    }
}
