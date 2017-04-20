package com.example.dictionary;

import org.hibernate.validator.constraints.NotEmpty;

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

    public static CommandParams of(String commandLine) {
        return new CommandParams(commandLine);
    }

    public class Args {
        @Size(min = 1)
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
    }
}
