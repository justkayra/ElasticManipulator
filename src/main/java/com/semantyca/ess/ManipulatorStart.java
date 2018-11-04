package com.semantyca.ess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.shell.SpringShellAutoConfiguration;
import org.springframework.shell.jcommander.JCommanderParameterResolverAutoConfiguration;
import org.springframework.shell.jline.JLineShellAutoConfiguration;
import org.springframework.shell.legacy.LegacyAdapterAutoConfiguration;

@EnableAutoConfiguration(exclude = { SecurityAutoConfiguration.class })
@Import({
        SpringShellAutoConfiguration.class,
        JLineShellAutoConfiguration.class,
        JCommanderParameterResolverAutoConfiguration.class,
        LegacyAdapterAutoConfiguration.class,
        ESClientFactory.class,
 //       StandardAPIAutoConfiguration.class,
 //       StandardCommandsAutoConfiguration.class,
//        PropertyPlaceholderAutoConfiguration.class,
        ShellCommandHandler.class
})
public class ManipulatorStart {

    public static void main(String[] args) {
        SpringApplication.run(ManipulatorStart.class, args);
    }

}
