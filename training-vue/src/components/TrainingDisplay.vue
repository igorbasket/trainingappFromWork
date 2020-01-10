<template>
    <div>
        Process
        <CountdownTimer class="time" :date="exercise.time"></CountdownTimer>
    </div>
</template>

<script>
    import CountdownTimer from './Timer.vue'

    export default {
        name: "TrainingDisplay",
        components: {
            CountdownTimer
        },
        data() {
            return {
                exercise: {
                    time: '100.00'
                }
            };

        }
    }
</script>

<style scoped>

</style>
