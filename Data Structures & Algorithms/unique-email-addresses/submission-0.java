class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<>();
        for (String email: emails) {
            emailSet.add(getValidEmail(email));
        }
        return emailSet.size();
    }

    private String getValidEmail(String email) {
        int i = 0;
        StringBuffer local = new StringBuffer();
        while (i < email.length() && email.charAt(i) != '@' && email.charAt(i) != '+') {
            if (email.charAt(i) != '.')
                local.append(email.charAt(i));
            i++;
        }
        while (i < email.length() && email.charAt(i) != '@') 
            i++;
        
        String domain = email.substring(i + 1);
        return local.toString() + "@" + domain;
    }
}