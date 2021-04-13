package liquibase.command.core;

import liquibase.command.*;
import liquibase.integration.commandline.Main;

public class GenerateChangeLogCommandStep extends AbstractCliWrapperCommandStep {
    public static final CommandArgumentDefinition<String> USERNAME_ARG;
    public static final CommandArgumentDefinition<String> PASSWORD_ARG;
    public static final CommandArgumentDefinition<String> URL_ARG;
    public static final CommandArgumentDefinition<String> CHANGELOG_FILE_ARG;

    static {
        CommandStepBuilder builder = new CommandStepBuilder(GenerateChangeLogCommandStep.class);
        USERNAME_ARG = builder.argument("username", String.class).build();
        PASSWORD_ARG = builder.argument("password", String.class).build();
        URL_ARG = builder.argument("url", String.class).required().build();
        CHANGELOG_FILE_ARG = builder.argument("changeLogFile", String.class).build();
    }

    @Override
    public String[] getName() {
        return new String[] {"generateChangeLog"};
    }

    @Override
    public void run(CommandResultsBuilder resultsBuilder) throws Exception {
        CommandScope commandScope = resultsBuilder.getCommandScope();

        String[] args = createArgs(commandScope);
        int statusCode = Main.run(args);
        addStatusMessage(resultsBuilder, statusCode);
        resultsBuilder.addResult("statusCode", statusCode);
    }
}
