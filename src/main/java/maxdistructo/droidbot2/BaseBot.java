package maxdistructo.droidbot2;

import de.btobastian.sdcf4j.CommandHandler;
import de.btobastian.sdcf4j.handler.JDA3Handler;
import maxdistructo.droidbot2.commands.Casino;
import maxdistructo.droidbot2.commands.Debug;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;

public class BaseBot {
    public static String PREFIX;
    public static void main(String[] args){
        String token = "MjY2NzMxNzg4NTk0OTcwNjM1.DAOsQQ.IqbKZsq5Rboc49qRAnm_WJpYLyk";
        JDA jda;
        try {
            jda = new JDABuilder(AccountType.BOT).setToken(token).buildBlocking();
            CommandHandler handler = new JDA3Handler(jda);
            handler.registerCommand(new Debug());
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } catch (RateLimitedException e) {
            e.printStackTrace();
        } catch (LoginException e) {
            e.printStackTrace();
        }



    }

}