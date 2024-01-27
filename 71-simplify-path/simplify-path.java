class Solution {
    public String simplifyPath(String path) {
        Stack <String> s = new Stack<>();
        String dirs[] = path.split("/");
        for (String dir : dirs) {
            if (dir.equals("..")) {
                if (!s.isEmpty()) s.pop();
            }
            else if (!dir.equals("") && !dir.equals(".")) s.push(dir);
        }
        String ans = !s.isEmpty() ? s.pop() : "";
        while (!s.isEmpty())
            ans = s.pop() + "/" + ans;
        return "/" + ans;
    }
}