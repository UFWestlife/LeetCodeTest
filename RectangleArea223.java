import java.util.Arrays;

/**
 * Created by Administrator on 07-Jun-007.
 */
public class RectangleArea223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int[] a = {A, E, C, G};
        int[] b = {F, B, H, D};
        Arrays.sort(a);
        Arrays.sort(b);

        if(A==B && B == C && C== D) return (G-E)*(H-F);
        if(E == F && F == G && G == H) return (C-A)*(D-B);

        int chang = 0, kuan = 0;
        if(a[0] == A && a[1] == E && a[2] == C && a[3] == G) chang = Math.abs(E-C);
        else if(a[0] == A && a[1] == E && a[2] == G && a[3] == C) chang = Math.abs(E-G);
        else if(a[0] == E && a[1] == A && a[2] == C && a[3] == G) chang = Math.abs(C-A);
        else if(a[0] == E && a[1] == A && a[2] == G && a[3] == C) chang = Math.abs(A-G);
        else chang = 0;

        if(b[0] == F && b[1] == B && b[2] == H && b[3] == D) kuan = Math.abs(H-B);
        else if(b[0] == B && b[1] == F && b[2] == D && b[3] == H) kuan = Math.abs(F-D);
        else if(b[0] == F && b[1] == B && b[2] == D && b[3] == H) kuan = Math.abs(B-D);
        else if(b[0] == B && b[1] == F && b[2] == H && b[3] == D) kuan = Math.abs(F-H);
        else kuan = 0;

        int cover = chang*kuan;

        return (C-A)*(D-B)+(G-E)*(H-F)-cover;
    }
}
