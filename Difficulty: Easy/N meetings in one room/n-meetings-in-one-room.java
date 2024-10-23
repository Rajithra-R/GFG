//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int n = a1.length;
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(a1[i]);
            }

            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            n = a2.length;
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(a2[i]);
            }

            int ans = new Solution().maxMeetings(a, b);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class meeting{
    int start;
    int end;
    int pos;
    meeting(int start,int end,int pos)
    {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}
class meetingcomparator implements Comparator<meeting>
{
    public int compare(meeting o1,meeting o2)
    {
        if(o1.end < o2.end) // add o1 before o1
            return -1;
        else if(o1.end > o2.end) // add o1 after o2
            return 1;
        else if(o1.pos < o2.pos) // if both end times are same then compare pos
            return -1;
        else
            return 1;
            
    }
}
class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        ArrayList<meeting> meet = new ArrayList<>();
        for(int i=0;i<start.length;i++)
        {
            meet.add(new meeting(start[i],end[i],i+1));
        }
        
        meetingcomparator mc = new meetingcomparator();
        Collections.sort(meet,mc);
        
        ArrayList<Integer> pos_arr = new ArrayList<>();
        pos_arr.add(meet.get(0).pos);
        int last = meet.get(0).end;
        int count = 1; // initially first one can proceed
        
        for(int i=0;i<start.length;i++)
        {
            if(meet.get(i).start > last)
            {
                count++;
                last = meet.get(i).end;
                pos_arr.add(meet.get(i).pos);
            }
        }
        return count;
    }
}
