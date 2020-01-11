<template>
    <div>
        <li v-for="elem in exercise.items" :key="elem.message">
            {{elem.message}}
        </li>
        Process
            <CountdownTimer class="time" :date="exercise.time" :data-timeout="exercise.timeout"></CountdownTimer>
    </div>
</template>

<script>
    // import CountdownTimer from './Timer.vue'
    import CountdownTimer from './Timer.vue'

    export default {
        name: "TrainingDisplay",
        components: {
            CountdownTimer,
        },
        data() {
            return {
                exercise: {
                    time: '5.00',
                    timeout: '10.00',
                    items: [
                        { message: 'Exercise 1' },
                        { message: 'Exercise 2' },
                        { message: 'Exercise 3' },
                        { message: 'Exercise 4' },
                        { message: 'Exercise 5' }
                ]
                }
            };

        }
    }
</script>

<style scoped>

</style>
