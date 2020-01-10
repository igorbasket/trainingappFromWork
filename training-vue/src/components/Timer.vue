<template>
    <div>
        <div v-if="minutes <= '0' && seconds <= '0'">
            <p style="color:red;">
                00:00
            </p>
        </div>
        <div v-else>
            <p> {{ Math.trunc(minutes) }}:{{ Math.trunc(seconds) }}
            </p>
        </div>
<!--        <small class="tet-muted">Data: {{count}}</small>-->
    </div>
</template>

<script>
    export default {
        name: "CountdownTimer",
        props: {
            date: {
                type: String
            }
        },
        data() {
            return {
                now: 0,
                count: Number(this.date),
                timeStop: 0
            }
        },
        methods: {
            timer_loop() {
                this.count--
                this.now = Math.trunc(new Date().getTime() / 1000)
                //console.log(this.now);
                setTimeout(this.timer_loop, 1000)
                if (this.count < 0){
                    this.count = this.timeStop
                }
            },
        },
        mounted() {
            this.timer_loop()
        },
        computed: {
            seconds() {
                return (this.count) % 60
            },
            minutes() {
                return ((this.count) / 60) % 60
            },
            // hours() {
            //     return ((this.modifiedDate - this.now) / 60 / 60) % 24
            // },
            // days() {
            //     return ((this.modifiedDate - this.now) / 60 / 60 / 24)
            // },
            // modifiedDate: function () {
            //     return Math.trunc(Date.parse(this.date) / 1000)
            // }
        }
    }
</script>

<style scoped>



</style>