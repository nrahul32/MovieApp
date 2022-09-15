package com.nrahul32.movieapp;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

// This bean gets created only for qa profile
@Profile("qa")
@Component
public class MyService {
}
