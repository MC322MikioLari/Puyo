package com.puyopuyo.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.puyopuyo.game.AppPuyo;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("Puyo Puyo");
		config.setResizable(false);	
		config.setWindowedMode(1245, 700);
		new Lwjgl3Application(new AppPuyo(), config);
	}
}
