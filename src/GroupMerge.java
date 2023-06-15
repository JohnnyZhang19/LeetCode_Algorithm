import java.util.LinkedList;
import java.util.Queue;

public class GroupMerge {

    public static void main(String[] args) {
        System.out.println(getProvince(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}})); //2
        System.out.println(getProvince(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}})); //3
        System.out.println(bfs(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}})); //2
        System.out.println(bfs(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}})); //3
        System.out.println(mergeFind(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}})); //2
        System.out.println(mergeFind(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}})); //3
    }

    //时间复杂度 O(N^2)
    //空间复杂度 O(2N)= O(N)
    //深度优先
    public static int getProvince(int[][] citiesConnected) {
        int cities = citiesConnected.length;
        boolean[] visited = new boolean[cities];//default false
        int provinces = 0; //计数器
        for (int i = 0; i < cities; i++) {
            if (!visited[i]) {
                //深度优先
                dfs(i, cities, visited, citiesConnected);
                provinces++;
            }
        }
        return provinces;
    }

    private static void dfs(int i, int cities, boolean[] visited, int[][] citiesConnected) {
        for (int j = 0; j < cities; j++) {
            if (citiesConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(j, cities, visited, citiesConnected);
            }
        }
    }

    //广度优先
    public static int bfs(int[][] citiesConnected) {
        int cities = citiesConnected.length;
        boolean[] visited = new boolean[cities];//default false
        int provinces = 0; //计数器
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < cities; i++) {
            if (!visited[i]) {
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int k = queue.poll();
                    visited[k] = true;
                    for (int j = 0; j < cities; j++) {
                        if (citiesConnected[i][j] == 1 && !visited[j]) {
                            queue.offer(j);
                        }
                    }
                }
                provinces++;
            }
        }
        return provinces;
    }

    //并查集
    public static int mergeFind(int[][] citiesConnected){
        int cities = citiesConnected.length;
        int[] head = new int[cities];
        int[] level = new int[cities];
        for (int i = 0; i < cities; i ++){
            head[i] = i;
            level[i] = 1;
        }
        for (int i = 0; i < cities; i ++) {
            for (int j = i+1; j < cities; j++) {
                if (citiesConnected[i][j] == 1)
                    merge(i,j,head,level);
            }
        }
        int count = 0;
        for (int i = 0; i < cities; i ++){
            if (head[i] == i)
                count++;
        }
        return count;
    }

    static void merge(int x, int y, int[] head, int[] level){
       int i = find(x,head);
       int j = find(y,head);
       if (i == j) return;
       if (level[i] <= level[j]){
           head[i] = j;
       }else {
           head[j] = i;
       }
       if (level[i] == level[j]){
           level[i]++;
           level[j]++;
       }
    }

    private static int find(int x, int[] head) {
        if (head[x] == x) return x;
        head[x] = find(head[x],head);
        return head[x];
    }
}













