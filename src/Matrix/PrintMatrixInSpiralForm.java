/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrix;

/**
 *
 * @author Neelabh
 */
import java.util.*;
public class PrintMatrixInSpiralForm {
    public static void  main(String [] args){
        Scanner scan=new Scanner(System.in);
        int row=scan.nextInt();
        int col=scan.nextInt();
        int [] [] matrix=new int[row][col];
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++){
                matrix[i][j]=scan.nextInt();
            }
        //printMatrix(matrix);
        List list=spiralOrder(matrix);
        Iterator itr=list.iterator();
        while(itr.hasNext())
            System.out.print(itr.next()+" ");
    }
    public static void printMatrix(int [][] matrix){
        int row=matrix.length;
        int col=matrix[0].length;
        int l,k,r,c;
        l=k=0;// l denotes initial value of column and
        // and k denotes initial value of row
        r=row;
        c=col;
        while(k<r && l<c){
            for(int i=l;i<c;i++)
                System.out.print(matrix[k][i]+" "); 
            k++;
            for(int i=k;i<r;i++)
                System.out.print(matrix[i][c-1]+" ");
            c--;
            if(k<r){
                for(int i=c-1;i>=l;i--)
                    System.out.print(matrix[r-1][i]+" ");
                r--;
            }
            if(l<c){
                for(int i=r-1;i>=k;i--)
                    System.out.print(matrix[i][l]+" "); 
                l++;
            }
        }
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<Integer>();
        int row=matrix.length;
        int col=matrix[0].length;
        int l,k,r,c;
        l=k=0;// l denotes initial value of column and
        // and k denotes initial value of row
        r=row;
        c=col;
        while(k<r && l<c){
            for(int i=l;i<c;i++)
                list.add(matrix[k][i]); 
            k++;
            for(int i=k;i<r;i++)
                list.add(matrix[i][c-1]);
            c--;
            if(k<r){
                for(int i=c-1;i>=l;i--)
                    list.add(matrix[r-1][i]);
                r--;
            }
            if(l<c){
                for(int i=r-1;i>=k;i--)
                    list.add(matrix[i][l]); 
                l++;
            }
        }
        return list;
    }
}
