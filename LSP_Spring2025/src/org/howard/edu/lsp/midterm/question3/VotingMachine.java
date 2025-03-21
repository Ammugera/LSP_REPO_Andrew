package org.howard.edu.lsp.midterm.question3;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple voting machine that collects votes for candidates.
 * It can add candidate, cast votes, and get the winner.
 */
public class VotingMachine {
    private Map<String, Integer> votes;

    /**
     * Constructor for VotingMachine. It initalizes the votes map.
     */
    public VotingMachine() {
        votes = new HashMap<>();
    }

    /**
     * Adds a candidate to the machine if not already added.
     * @param candidate the name of the candidate.
     */
    public void addCandidate(String candidate) {
        if (!votes.containsKey(candidate)) {
            votes.put(candidate, 0);
        }
    }

    /**
     * Casts a vote for a candidate.
     * @param candidate the candidate to vote for.
     * @return true if the vote was cast, false if the candidate does not exist.
     */
    public boolean castVote(String candidate) {
        if (votes.containsKey(candidate)) {
            votes.put(candidate, votes.get(candidate) + 1);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gets the winner of the election.
     * @return a string with the winner and vote count, or a message if no votes were cast.
     */
    public String getWinner() {
        String winner = null;
        int maxVotes = 0;
        for(Map.Entry<String, Integer> entry : votes.entrySet()){
            if(entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }
        if(winner != null) {
            return winner + " WINS with " + maxVotes + " votes!!";
        } else {
            return "No votes cast";
        }
    }
}
