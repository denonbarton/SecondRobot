package bot.controller;

import bot.model.EV3Bot;

public class BotController
{
	private EV3Bot denonBot;
	
	public BotController()
	{
		denonBot = new EV3Bot();
	}
	public void start()
	{
		denonBot.driveRoom();
	}
}
