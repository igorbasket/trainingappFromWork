<template>
    <section id="app" class="hero is-warning is-fullheight is-bold">
        <div class="hero-body">
            <div class="container has-text-centered">

                <h2 class="title is-6">{{ message }}</h2>

                <!--  THE TIMER NUMBERS  -->
                <div id="timer">
                    <span id="minutes">{{ minutes | twoDigits }}</span>
                    <span id="middle">:</span>
                    <span id="seconds">{{ seconds | twoDigits }}</span>
                </div>

                <!--  THE BUTTONS  -->
                <div id="buttons">

                    <!--  START BUTTON    -->
                    <button
                            id="start"
                            class="button is-dark is-large"
                            @click='startTimer'
                            v-show="showContinue">start
<!--                        <i class="far fa-play-circle"></i>-->
                    </button>

                    <!--   PAUSE BUTTON   -->
                    <button
                            id="stop"
                            class="button is-dark is-large"
                            @click="pauseTimer"
                            v-show='!showContinue'>stop
<!--                        <i class="far fa-pause-circle"></i>-->
                    </button>

                    <!--  RESET BUTTON   -->
                    <button
                            id="reset"
                            class="button is-dark is-large"
                            @click="resetTimer"
                            v-show="showReset">reset
<!--                        <i class="fas fa-undo"></i>-->
                    </button>
                </div>

            </div>
        </div>
    </section>
</template>

<script>
    const default_title = 'Let the countdown begin!!';

    export default {
        name: "Timer3",
        el: '#app',
        data() {
            return {
                message: default_title,
                minutes: 25,
                seconds: 0,
                interval: null,
                showContinue: true,
                showReset: false
            }
        },
        methods: {
            startTimer: function(){
                this.showContinue = false,
                    this.showReset = true,
                    this.message = 'Greatness is within sight!!';
                this.interval = setInterval(() => {
                    if(this.seconds === 0){
                        this.seconds = 59;
                        this.minutes--;
                    }else{
                        this.seconds--;
                    }

                    if(this.minutes === 0 && this.seconds === 0){
                        this.resetTimer()
                    }
                },1000)
            },
            pauseTimer: function(){
                this.showReset = true,
                    this.showContinue = true;
                this.message = 'Never quit, keep going!!';
                clearInterval(this.interval);
            },
            resetTimer: function(){
                this.showContinue = true;
                this.showReset = true,
                    this.minutes = 25;
                this.seconds = 0
                this.message = default_title;
            }
        },
        filters:{
            twoDigits: function(num){
                if(num<10){
                    return '0'+ num
                }else{
                    return num
                }
            }
        }
    }
</script>

<style scoped>
    #message {
        color: #DDD;
        font-size: 50px;
        margin-bottom: 20px;
    }

    #timer {
        font-size: 150px;
        line-height: 1;
        margin-bottom: 40px;
    }
</style>