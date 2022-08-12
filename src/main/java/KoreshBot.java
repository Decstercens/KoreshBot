import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class KoreshBot extends ListenerAdapter {
    public static void main(String[] args) throws LoginException {
        String token="";
        JDABuilder.createLight(token, GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES, GatewayIntent.MESSAGE_CONTENT)
                .addEventListeners(new KoreshBot())
                .setActivity(Activity.playing("Type !ping"))
                .build();
    }
    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        System.out.println("We received a message from "+
                event.getAuthor().getName()+
                " he wrote: "+
                event.getMessage().getContentRaw());
        if (event.getMessage().getContentRaw().equals("!ping"))
        {
            event.getChannel().sendMessage("Pong!").queue();
        }
    }
}