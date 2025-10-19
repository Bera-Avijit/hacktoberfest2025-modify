import java.util.Scanner;
import java.util.Stack;

public class CelebrityProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the matrix : ");
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        System.out.println("Enter the elements of the matrix : ");
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int celeb = findCelebrity(arr);
        if(celeb == -1){
            System.out.println("No celebrity found");
        } else {
            System.out.println("Celebrity is at index: " + celeb);
        }
    }

    private static int findCelebrity(int[][] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            st.push(i);
        }
        while(st.size() >= 2){
            int a = st.pop();
            int b = st.pop();
            if(arr[a][b] == 1){
                st.push(b);
            } else {
                st.push(a);
            }
        }
        int celeb = st.pop();
        for(int i=0; i<n; i++){
            if(i != celeb){
                if(arr[celeb][i] == 1 || arr[i][celeb] == 0){
                    return -1;
                }
            }
        }
        return celeb;
    }
}
