
import java.util.ArrayList;
import java.util.List;

public class Team {

    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("A name should not be empty.");
        }
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public String getName() {
        return name;
    }

    public void removePlayer(String name) {
        this.players.removeIf(player -> name.equals(player.getName()));
    }
    public boolean hasPlayer(String name) {
        return players.stream().anyMatch(player -> name.equals(player.getName()));
    }

    public List<Player> getPlayers() {
        return players;
    }

    public double getRating(){
        return players.stream().mapToDouble(Player::overallSkillLevel).average().orElse(0.0);
    }

}
