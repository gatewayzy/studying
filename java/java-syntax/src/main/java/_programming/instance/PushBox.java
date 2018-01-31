package _programming.instance;

import java.util.*;

public class PushBox {
    static {
        System.out.println("3 6\n" +
                ".S#..E\n" +
                ".#.0..\n" +
                "......");
        System.out.println("人一共走的步数：13");
    }

    int r;//地图行数
    int c;//地图列数
    int begx, begy;//箱子开始坐标
    int endx, endy;//目标坐标
    int begsx, begsy;//人开始坐标
    char map[][];//地图
    int[] dx = {-1, 1, 0, 0};//人和箱子都有四个方向可移动
    int[] dy = {0, 0, 1, -1};
    char[] P = {'N', 'S', 'E', 'W'};//表示箱子向某个方向移动
    char[] M = {'n', 's', 'e', 'w'};//表示人向某个方向移动
    Node f = new Node(0, 0, 0, 0, "");
    Node g = new Node(0, 0, 0, 0, "");
    node1 F = new node1(0, 0, "");
    node1 G = new node1(0, 0, "");
    int mark[][];//标志数组，表示地图上某一位置mark[i][j]是否访问过。


    public PushBox(char[][] map, int r, int c, int begx, int begy, int endx, int endy, int begsx, int begsy) {
        this.map = map;
        this.r = r;
        this.c = c;
        this.begx = begx;
        this.begy = begy;
        this.endx = endx;
        this.endy = endy;
        this.begsx = begsx;
        this.begsy = begsy;
        mark = new int[r][c];
    }


    public boolean ok(int x, int y) {
        if (x >= 0 && x < r && y >= 0 && y < c) return true;
        return false;
    }

    public boolean SToB(int bx, int by, int ex, int ey) {//人到箱子BFS

        int[][] Mark1 = new int[r][c];   //标志数组，表示地图上某一位置Mark1[i][j]是否访问过。

        Queue<node1> P = new LinkedList<node1>();
        Mark1[bx][by] = 1;
        Mark1[f.bx][f.by] = 1;
        F.x = bx;
        F.y = by;
        F.ans = "";
        if (bx == ex && by == ey) return true;//到达目标
        P.offer(new node1(F.x, F.y, F.ans));
        while (!P.isEmpty()) {
            F = P.poll();
            for (int i = 0; i < 4; ++i) {//向四个方向扩展
                G.x = F.x + dx[i];
                G.y = F.y + dy[i];
                if (!ok(G.x, G.y) || map[G.x][G.y] == '#') continue;
                if (Mark1[G.x][G.y] == 0) {//此点没有访问过

                    Mark1[G.x][G.y] = 1;//标记为已访问
                    G.ans = F.ans + M[i];
                    if (G.x == ex && G.y == ey) {
                        F = G;
                        return true;
                    }
                    P.add(new node1(G.x, G.y, G.ans));

                }
            }
        }
        return false;
    }

    public boolean bfs() {//箱子向目标bfs
        Queue<Node> Q = new LinkedList<Node>();
        f.bx = begx;
        f.by = begy;//f:人与箱子所在的位置
        f.px = begsx;
        f.py = begsy;
        f.ans = "";
        mark[begx][begy] = 1;
        Q.offer(new Node(f.bx, f.by, f.px, f.py, f.ans));
        while (!Q.isEmpty()) {
            f = Q.poll();//出队列
            for (int i = 0; i < 4; ++i) {//检查f的所有邻接点，向四个方向扩展
                int newx = f.bx + dx[i];
                int newy = f.by + dy[i];//箱子前一位置
                int tx = f.bx - dx[i];
                int ty = f.by - dy[i];//箱子后一位置
                if (!ok(newx, newy) || map[newx][newy] == '#' || !ok(tx, ty)
                        || map[tx][ty] == '#' || mark[newx][newy] == 1) continue;
                if (SToB(f.px, f.py, tx, ty)) {//检查人能否来
                    g.bx = newx;
                    g.by = newy;
                    g.px = f.bx;
                    g.py = f.by;
                    g.ans = f.ans + F.ans + P[i];
                    if (g.bx == endx && g.by == endy) {
                        return true;
                    }
                    mark[newx][newy] = 1;
                    Q.add(new Node(g.bx, g.by, g.px, g.py, g.ans));
                }
            }
        }
        return false;
    }


    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int r = 0;
        int c = 0;
        String s = "";
        int begx = 0;
        int begy = 0;
        int endx = 0;
        int endy = 0;
        int begsx = 0;
        int begsy = 0;
        char[][] map = null;
        int t = 1;
        while (in.hasNext()) {
            r = in.nextInt();
            c = in.nextInt();
            in.nextLine();
            if (r == 0 && c == 0) break;
            map = new char[r][c];
            for (int i = 0; i < r; i++) {
                s = in.nextLine();
                for (int j = 0; j < c; j++) {
                    map[i][j] = s.charAt(j);
                    if (map[i][j] == '0') {
                        begx = i;
                        begy = j;
                    }//箱子开始坐标
                    if (map[i][j] == 'E') {
                        endx = i;
                        endy = j;
                    }//目标坐标
                    if (map[i][j] == 'S') {
                        begsx = i;
                        begsy = j;
                    }//人开始坐标
                }

            }
            PushBox ma = new PushBox(map, r, c, begx, begy, endx, endy, begsx, begsy);
            if (ma.bfs()) {
                System.out.println("Maze #" + t++);
                String s1 = ma.g.ans;
                System.out.println(s1);
                System.out.println(s1.length());
                System.out.println();
            } else {
                System.out.println("Maze #" + t++);
                System.out.println("Impossible.");
                System.out.println();
            }
        }
    }

}

class node1 {
    int x;
    int y;
    String ans;

    node1(int x, int y, String ans) {
        this.x = x;
        this.y = y;
        this.ans = ans;
    }
}

class Node {
    int bx;
    int by;
    int px;
    int py;
    String ans;

    Node(int bx, int by, int px, int py, String ans) {
        this.bx = bx;
        this.by = by;
        this.px = px;
        this.py = py;
        this.ans = ans;
    }
}
