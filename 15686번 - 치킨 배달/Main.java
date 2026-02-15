/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 15686                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/15686                          #+#        #+#      #+#    */
/*   Solved: 2026/02/15 21:22:34 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb;
    static int n;
    static int m;
    static List<Point> chicken;
    static List<Point> house;
    static boolean[] picked;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        house = new ArrayList<>();
        chicken = new ArrayList<>();
        for(int i=0; i<n; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<n; j++){
                int k = Integer.parseInt(st2.nextToken());
                if(k==1){
                    house.add(new Point(i,j));
                }else if(k==2){
                    chicken.add(new Point(i,j));
                }
            }
        }
        picked = new boolean[chicken.size()];
        min = Integer.MAX_VALUE;
        chickenPick(0,0);
        System.out.println(min);
    }
    public static void chickenPick(int start, int count){
        if(count == m){
            calculateDistance();
            return;
        }
        for(int i=start; i<chicken.size(); i++) {
            picked[i] = true;
            chickenPick(i+1,count+1);
            picked[i] = false;
        }
    }
    public static void calculateDistance(){
        int totalDist = 0;
        List<Point> selected = new ArrayList<>();
        for(int i=0; i<chicken.size(); i++){
            if(picked[i]){
                selected.add(chicken.get(i));
            }
        }

        for(Point h :house){
            int minDist = Integer.MAX_VALUE;
            for(Point c: selected){
                int d = Math.abs(h.x - c.x) + Math.abs(h.y - c.y);
                minDist = Math.min(d,minDist);
            }
            totalDist += minDist;
        }
        min = Math.min(min,totalDist);
    }
    static class Point{
        int x;
        int y;
        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}