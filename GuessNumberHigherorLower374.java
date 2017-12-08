public class GuessNumberHigherorLower374 {
        int answer = 5;//the number you want
    public int guess(int guess){
        if (answer < guess) return -1;
        if (answer > guess) return 1;
        return 0;
    }
    public int guessNumber(int n) {
        return bsearch(1,n);
    }
    private int bsearch(int start,int end){//Binary Search
        if(start>end) return -1;
        if(guess(start)==0) return start;
        if(guess(end)==0) return end;
        int mid = start+(end-start)/2;
        if(guess(mid)==0) return mid;
        else if(guess(mid)==-1) return bsearch(start+1,mid-1);
        else return bsearch(mid+1,end-1);
    }
}
