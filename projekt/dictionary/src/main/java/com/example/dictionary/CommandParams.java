package com.example.dictionary;

import com.example.dictionary.validation.HelpValidationGroup;
import org.apache.bval.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CommandParams {

    @NotEmpty
    public final String command;

    @Valid
    public final Args args;

    private CommandParams (String commandLine) {
        String[] split = commandLine.split(" ");
        this.command = split[0];
        this.args = new Args(Arrays.copyOfRange(split, 1, split.length));
    }

    @Override
    public String toString() {
        return "CommandParams{" +
                "command='" + command + '\'' +
                ", args=" + args +
                '}';
    }

    public static CommandParams of(String commandLine) {
        return new CommandParams(commandLine);
    }

    public class Args {

        @NotEmpty
        @Size(min = 2, groups = HelpValidationGroup.class)
        final List<String> args;

        private Args() {
            args = Collections.emptyList();
        }

        private Args(String[] a) {
            this.args = Arrays.asList(a);
        }

        public String first() {
            return args.iterator().next();
        }

        @Override
        public String toString() {
            return "Args" + args;
        }
    }
}
