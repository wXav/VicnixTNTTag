package net.vicnix.tnttag.session;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SessionManager {

    private static final SessionManager instance = new SessionManager();

    private Map<UUID, Session> sessionMap = new HashMap<>();

    public static SessionManager getInstance() {
        return instance;
    }

    public void createSession(Player player) {
        if (this.sessionMap.containsKey(player.getUniqueId())) return;

        this.sessionMap.put(player.getUniqueId(), new Session(player.getName(), player.getUniqueId()));
    }

    public void closeSession(Player player) {
        if (!this.sessionMap.containsKey(player.getUniqueId())) return;

        this.sessionMap.remove(player.getUniqueId());
    }
}