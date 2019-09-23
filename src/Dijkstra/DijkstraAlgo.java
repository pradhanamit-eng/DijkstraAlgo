package Dijkstra;

import java.util.Scanner;

public class DijkstraAlgo {
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter no of Vertices:");
		int v = sc.nextInt();
		System.out.print("Enter no of Edges:");
		int e = sc.nextInt();
		
		int adjacencyMatrix[][]=new int[v][v];
		System.out.println("Enter the AdjacencyMatrix:");
		for(int i=0;i<e;i++)
		{
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int weight = sc.nextInt();
			adjacencyMatrix[v1][v2] = weight;
			adjacencyMatrix[v2][v1] = weight;
		}
		
		dijkstra(adjacencyMatrix);
		
		//v=5 e=7
		//0 1 4 
		//0 2 8 
		//1 3 5
		//1 2 2
		//2 3 5 
		//2 4 9
		//3 4 4
		
	}

	private static void dijkstra(int[][] adjacencyMatrix) {
		
		int v = adjacencyMatrix.length;
		boolean visited[]=new boolean[v];
		int distance[] =  new int[v];
		distance[0] = 0;
		for (int i = 1; i < v; i++) 
		{
			distance[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 0; i < v-1; i++) 
		{
			//find vertex with minimum distance 
			int minVertex = findMinVertex(distance, visited);
			visited[minVertex] = true;
			//explore neighbors
			for (int j = 0; j < v; j++) 
			{
				if(adjacencyMatrix[minVertex][j]!=0 && !visited[j] && distance[minVertex] !=Integer.MAX_VALUE)
				{
					int newDist = distance[minVertex]+adjacencyMatrix[minVertex][j];
					if(newDist<distance[j])
					{
						distance[j] = newDist; 
					}
				}
			}
			
			
		}
		
		//print
		for (int i =0; i < v; i++) 
		{
			System.out.println(i+" "+distance[i]);
		}
		
	}

	private static int findMinVertex(int[] weight, boolean visited[]) {
		int minVertex = -1;
		for(int i=0;i<weight.length;i++)
		{
			if (!visited[i] && (minVertex == -1 || weight[i] < weight[minVertex]))
			{
				minVertex = i;
			}
		}
		return minVertex;
		
	}

}
