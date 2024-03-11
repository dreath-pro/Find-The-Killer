package com.example.findthekiller.model;

import android.text.Layout;
import android.text.style.AlignmentSpan;

import java.util.ArrayList;
import java.util.Random;

public class MessageModel {
    private StringBuilder message = new StringBuilder();
    private PlayerModel playerModel;
    private Random random = new Random();

    public MessageModel(PlayerModel playerModel)
    {
        this.playerModel = playerModel;
        message.setLength(0);
    }

    public String selectGreeting()
    {
        message.append(playerModel.getName()).append(": ");

        int selectGreeting = random.nextInt(12);
        switch (selectGreeting) {
            case 0:
                message.append("Hi there, my name is ").append(playerModel.getName()).append(". Feel free to ask me any questions!");
                break;
            case 1:
                message.append("Hey! I'm ").append(playerModel.getName()).append(", here to answer any questions you might have.");
                break;
            case 2:
                message.append("Hello, there! ").append(playerModel.getName()).append(" here, ready for your curious inquiries.");
                break;
            case 3:
                message.append("Greetings! It's ").append(playerModel.getName()).append(", feel free to shoot me any questions your heart desires.");
                break;
            case 4:
                message.append("Hi there, ").append(playerModel.getName()).append(" at your service! Ask away, and let's have a chat.");
                break;
            case 5:
                message.append("Yo, what's up? ").append(playerModel.getName()).append(" in the house, hit me up with your questions!");
                break;
            case 6:
                message.append("Howdy, it's ").append(playerModel.getName()).append("! Ask away, and let's dive into some intriguing conversations!");
                break;
            case 7:
                message.append("Top of the day to ya! I'm ").append(playerModel.getName()).append(", your friendly stranger question-answerer. Fire away!");
                break;
            case 8:
                message.append("Hey, hey! ").append(playerModel.getName()).append(" in the building, ready for the ultimate Q&A showdown. What's your move?");
                break;
            case 9:
                message.append("Greetings and salutations! It's ").append(playerModel.getName()).append(", your go-to guy for all things questions. Lay 'em on me!");
                break;
            case 10:
                message.append("Yo, it's ").append(playerModel.getName()).append("! Drop your questions like they're hot!");
                break;
            case 11:
                message.append("What's kickin', amigo? I'm ").append(playerModel.getName()).append(", throw your questions at me!");
                break;
        }

        message.append("\n\n");

        return message.toString();
    }

    public String askQuestion()
    {
        message.append("You").append(": ");

        int selectQuestion = random.nextInt(12);
        switch (selectQuestion) {
            case 0:
                message.append("Can you disclose your whereabouts during the incident and describe your actions?");
                break;
            case 1:
                message.append("Where were you located at the time, and could you elaborate on your activities?");
                break;
            case 2:
                message.append("What was your location when everything went down, and what were you up to?");
                break;
            case 3:
                message.append("During the incident, where were you situated, and can you outline your actions?");
                break;
            case 4:
                message.append("Can you shed light on your position when it happened and detail your engagement?");
                break;
            case 5:
                message.append("At the time of the incident, where were you positioned, and what activities were you involved in?");
                break;
            case 6:
                message.append("Where exactly were you positioned when the incident occurred, and what were your actions at that moment?");
                break;
            case 7:
                message.append("During the critical moment, where were you situated, and what sort of activities were you engaged in?");
                break;
            case 8:
                message.append("Could you reveal your location when everything unfolded and provide details on your actions at that specific time?");
                break;
            case 9:
                message.append("At the time of the incident, where did you find yourself, and what activities were occupying your attention?");
                break;
            case 10:
                message.append("Can you pinpoint your location during the event and provide insights into your actions during that period?");
                break;
            case 11:
                message.append("When the incident took place, where were you, and what specific activities were you immersed in at that time?");
                break;
        }

        message.append("\n\n");

        playerResponse();

        return message.toString();
    }

    private void playerResponse()
    {
        message.append(playerModel.getName()).append(": ");

        StringBuilder groupChat = new StringBuilder();
        groupChat.append(" by myself ");
        for(int i = 1; i <= playerModel.getGroups().size(); i++)
        {
            if(i == 1)
            {
                groupChat.setLength(0);
                groupChat.append(" with ");
            }

            groupChat.append(playerModel.getGroups().get(i - 1).getName());

            if((i + 1) == playerModel.getGroups().size())
            {
                groupChat.append(" and ");
            }else if(i < playerModel.getGroups().size())
            {
                groupChat.append(", ");
            }

            if(i == playerModel.getGroups().size())
            {
                groupChat.append(".");
            }
        }

        int selectResponse = random.nextInt(12);
        switch (selectResponse) {
            case 0:
                message.append("At the time of the incident, I was ").append(playerModel.getActivity()).append(groupChat);
                break;
            case 1:
                message.append(playerModel.getActivity()).append(groupChat).append(" That's where I was when everything went down.");
                break;
            case 2:
                message.append("During the incident, my focus was ").append(playerModel.getActivity()).append(groupChat);
                break;
            case 3:
                message.append("I was right in the middle of ").append(playerModel.getActivity()).append(groupChat).append(" When the incident took place.");
                break;
            case 4:
                message.append(playerModel.getActivity()).append(groupChat).append(" That's how I spent the moments of the incident.");
                break;
            case 5:
                message.append("At the time of the incident, I found myself ").append(playerModel.getActivity()).append(groupChat).append(" Creating a backdrop of laughter and camaraderie.");
                break;
            case 6:
                message.append("As the incident transpired, I found myself ").append(playerModel.getActivity()).append(" Surrounded by the atmosphere").append(groupChat);
                break;
            case 7:
                message.append("In the moments of the incident, my focus was ").append(playerModel.getActivity()).append(groupChat).append(" Creating a vibrant atmosphere.");
                break;
            case 8:
                message.append(playerModel.getActivity()).append(groupChat).append(" The incident became an unexpected twist in the activity, adding an unexpected layer to the evening.");
                break;
            case 9:
                message.append("Amidst ").append(playerModel.getActivity()).append(groupChat).append(" The incident cast an unexpected shadow over the good moment.");
                break;
            case 10:
                message.append("In the midst of ").append(playerModel.getActivity()).append(groupChat).append(" The incident injected an unexpected twist into the night.");
                break;
            case 11:
                message.append(playerModel.getActivity()).append(groupChat).append(" Little did I know that the incident would become a pivotal point in the otherwise carefree evening.");
                break;
        }

        message.append("\n\n");
    }
}
