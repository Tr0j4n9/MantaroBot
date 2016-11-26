package net.kodehawa.mantarobot.cmd;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.kodehawa.mantarobot.cmd.management.Command;
import net.kodehawa.mantarobot.util.StringArrayFile;
public class Hi extends Command {

	public static CopyOnWriteArrayList<String> greeting = new CopyOnWriteArrayList<String>();
	
	public Hi()
	{
		setName("hi");
		new StringArrayFile("Greetings", "mantaro", greeting, false);
	}
	

	@Override
	public void onCommand(String[] message, String beheadedMessage, MessageReceivedEvent evt) {
		Random rd = new Random();
	    int greetRandomizer = rd.nextInt(greeting.size());
        channel = evt.getChannel();

	    channel.sendMessage(greeting.get(greetRandomizer)).queue(sentMessage -> 
	    {
	    	String messageId = evt.getMessage().getId();
	    	channel.deleteMessageById(messageId).queue();
	    });

	}
}