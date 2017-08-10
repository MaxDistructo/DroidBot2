package maxdistructo.droidbot2.background;

import com.sun.javafx.tk.PermissionHelper;
import maxdistructo.droidbot2.background.message.Message;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.managers.RoleManager;
import net.dv8tion.jda.core.managers.RoleManagerUpdatable;
import net.dv8tion.jda.core.managers.fields.PermissionField;
import sx.blah.discord.handle.obj.*;

import java.util.EnumSet;
import java.util.List;

import static maxdistructo.droidbot2.BaseBot.jda;

public class Roles {
    public static boolean checkForBotAbuse(IMessage message){
        IUser user = message.getAuthor();
        List<IRole> rolesList = user.getRolesForGuild(message.getGuild());
        IRole[] roles = rolesList.toArray(new IRole[rolesList.size()]);
        int i = 0;
        while(i < roles.length){
            if(roles[i].getLongID() == 330346559093080067L){
                return true;
            }
            i++;
        }
        return false;
    }
    public static boolean checkForPayday(IMessage message){
        IUser user = message.getAuthor();
        List<IRole> rolesList = user.getRolesForGuild(message.getGuild());
        IRole[] roles = rolesList.toArray(new IRole[rolesList.size()]);
        int i = 0;
        while(i < roles.length){
            if(roles[i].getLongID() == 330353751116480512L){
                i = roles.length;
                return true;
            }
            i++;
        }
        return false;
    }
    public static void applyBotAbuser(IMessage message, IUser mentioned){
        IRole role = message.getGuild().getRoleByID(330346559093080067L);
        mentioned.addRole(role);
    }
    public static void applyPayday(IMessage message, IUser mentioned){
        IRole role = message.getGuild().getRoleByID(330353751116480512L);
        mentioned.addRole(role);
    }
    public static void removeBotAbuser(IMessage message, IUser mentioned){
        IRole role = message.getGuild().getRoleByID(330346559093080067L);
        mentioned.removeRole(role);
    }
    public static void removePayday(IMessage message, IUser mentioned) {
        IRole role = message.getGuild().getRoleByID(330353751116480512L);
        mentioned.removeRole(role);
    }
    public static void applyRole(IMessage message, IUser mentioned, String role){
        List<IRole> roleList = message.getGuild().getRolesByName(role);
        if(roleList == null){
            Message.sendMessage(message.getChannel(), "The role "+ role + " was not found.");
            Thread.interrupted();
        }
        mentioned.addRole(roleList.get(0));
    }
    public static void applyRole(IMessage message, IUser mentioned, long roleL){
        IRole role = message.getGuild().getRoleByID(roleL);
        if(role == null){
            Message.sendMessage(message.getChannel(), "The role "+ roleL + " was not found.");
            Thread.interrupted();
        }
        mentioned.addRole(role);
    }
    public static void changeRolePerm(IMessage message, String perm, String role){
        List<IRole> roleList = message.getGuild().getRolesByName(role);
        if(roleList == null){
            Message.sendMessage(message.getChannel(), "The role "+ role + " was not found.");
            Thread.interrupted();
        }
        IRole roleNew = roleList.get(0);
        EnumSet<Permissions> set = roleNew.getPermissions();
        switch (perm){
            case "muteUsers":
                set.add(Permissions.VOICE_MUTE_MEMBERS);
            case "manageNicknames":
                set.add(Permissions.MANAGE_NICKNAMES);
            case "manageRoles":
                set.add(Permissions.MANAGE_ROLES);
            case "attachFiles":
                set.add(Permissions.ATTACH_FILES);
            case "addReactions":
                set.add(Permissions.ADD_REACTIONS);
            case "banMembers":
                set.add(Permissions.BAN);
            case "changeOwnUsername":
                set.add(Permissions.CHANGE_NICKNAME);
            case "createInvite":
                set.add(Permissions.CREATE_INVITE);
            case "embed":
                set.add(Permissions.EMBED_LINKS);
            case "kick":
                set.add(Permissions.KICK);
            case "manageThisChannel":
                set.add(Permissions.MANAGE_CHANNEL);
            case "manageChannels":
                set.add(Permissions.MANAGE_CHANNELS);
            case "manageEmojis":
                set.add(Permissions.MANAGE_EMOJIS);

        }
        roleNew.changePermissions(set);


        }
    }

