package dto;

import com.example.projetspring.GameModel.Player;
import lombok.Data;

@Data
public class ConnectRequest {
    private Player player;
    private String gameId;
}
