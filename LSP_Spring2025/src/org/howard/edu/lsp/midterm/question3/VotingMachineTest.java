package org.howard.edu.lsp.midterm.question3;

/**
 *  test class for the VotingMachine
 */
public class VotingMachineTest {
    /**
     * Main method to run the voting machine test
     * @param args command line arguments
     */
    public static void main(String[] args) {
        VotingMachine vm = new VotingMachine();

        // Adding candidates
        vm.addCandidate("Alice");
        vm.addCandidate("Bob");
        vm.addCandidate("Charlie");

        // Casting votes
        vm.castVote("Alice");
        vm.castVote("Alice");
        vm.castVote("Bob");
        vm.castVote("Charlie");
        vm.castVote("Charlie");
        vm.castVote("Charlie");

        // If someone attempts to vote for a candidate that doesn't exist
        boolean success = vm.castVote("Eve");
        System.out.println("Vote for Eve successful? " + success);

        // Display the winner
        System.out.println("Winner: " + vm.getWinner());
    }
}
