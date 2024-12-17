package com.xv.DataStruction.Graph;
import java.util.ArrayList;
import java.util.LinkedList;
public class search {
    //dfs  -- 深度优先搜索
    public static void dfs1(Vertex v){  //使用递归
        v.visited = true;
        for(Edge edge : v.edge){
            if(!edge.link.visited){
                dfs1(edge.link);
            }
        }
    }
    public static void dfs2(Vertex v){  //使用非递归
        LinkedList<Vertex> stack = new LinkedList<>();
        stack.push(v);
        while(!stack.isEmpty()){
            Vertex pop = stack.pop();
            pop.visited = true;
            for(Edge edge : pop.edge){
                if(!edge.link.visited){
                    stack.push(edge.link);
                }
            }
        }
    }
    //bfs  --- 广度优先搜索
    public static void bfs(Vertex v){
        LinkedList<Vertex> queue = new LinkedList<>();  //准备队列
        queue.offer(v);
        while(!queue.isEmpty()){
           // push -- pop   offer -- poll
           Vertex poll = queue.poll();
           poll.visited = true;
           for(Edge edge : poll.edge){
               if(!edge.link.visited){
                   queue.offer(edge.link);
               }
           }
        }
    }
    //拓扑排序
    public static void sort(ArrayList<Vertex> list){
        for(Vertex v : list){
            for(Edge edge : v.edge){
                edge.link.indegree++;   //记录各个节点的入度
            }
        }
        LinkedList<Vertex> queue = new LinkedList<>();  //准备一个队列
        for(Vertex v : list){    //将入度为0的元素进入队列
            if(v.indegree == 0){
                queue.offer(v);
            }
        }
        while(!queue.isEmpty()){   //进行排序
            Vertex poll = queue.poll();
            for(Edge edge : poll.edge){
                edge.link.indegree--;
                if(edge.link.indegree == 0){
                    queue.offer(edge.link);
                }
            }
        }
    }

}
