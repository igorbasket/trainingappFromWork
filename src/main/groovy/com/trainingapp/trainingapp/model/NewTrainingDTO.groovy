package com.trainingapp.trainingapp.model

import com.trainingapp.trainingapp.domain.Exercise

import java.time.LocalDateTime

class NewTrainingDTO {
    String name

    LocalDateTime data

    List<Exercise> exercise = []

}
