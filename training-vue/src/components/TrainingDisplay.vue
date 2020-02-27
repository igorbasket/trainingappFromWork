<template>
    <div>
        <small class="tet-muted">Data: {{this.myTrain}}</small>
<!--        <CountdownTimer class="time" :date="exercise.time" :data-timeout="exercise.timeout"></CountdownTimer>-->

        <el-carousel :interval="5000" arrow="always">
            <el-carousel-item v-for="elem in this.myTrain" :key="elem.message">
                <h3>{{ elem.name }}</h3>
            </el-carousel-item>
        </el-carousel>

<!--        <li v-for="elem in exercise.items" :key="elem.message">-->
<!--            {{elem.message}}-->
<!--        </li>-->
<!--        <div>-->
<!--            {{this.exercise.displayEx}}-->
<!--        </div>-->

        <CountdownTimer></CountdownTimer>

    </div>
</template>

<script>
     // import CountdownTimer from './Timer.vue'
    import CountdownTimer from './Timer2.vue'

    export default {

        name: "TrainingDisplay",
        components: {
            CountdownTimer,
        },
        props: ['ex'],
        data() {
            return {
                exercise: {
                    time: '12',
                    timeout: '10.00',
                    items: [
                        { message: 'Exercise 1' },
                        { message: 'Exercise 2' },
                        { message: 'Exercise 3' },
                        { message: 'Exercise 4' },
                        { message: 'Exercise 5' }
                ],
                    displayEx: 10000
                },
                myTrain: null
            };

        },
        methods: {
            exerciseArray () {
                let current = 0;
                // setTimeout(this.exerciseArray, 1000)

                for (let i=0; i<this.exercise.items.length; i++) {
                    this.exercise.displayEx = this.exercise.items[i];
                }

                this.exercise.displayEx = this.exercise.items[current];
                current++;
                // if(current >= this.exercise.items.length) current = 0;


                // setInterval(function(){
                //     this.displayEx = this.items[current];
                //     current++;
                //     if(current >= this.items.length) current = 0;
                // }, 2000);
            }
        },
        mounted() {
            // this.exerciseArray()


            this.$http.get('api/training/' + this.ex +'/')
                .then(response => {
                    this.myTrain = response.data
                })
                .catch(response => {
                    //debugger
                    alert(response.status)
                })
            // this.items.forEach(function(item){
            //     copy.push(item)
            // });
        },

    }
</script>

<style scoped>
    .el-carousel__item h3 {
        color: #475669;
        font-size: 70px;
        opacity: 0.75;
        line-height: 300px;
        margin: 0;
    }

    .el-carousel__item:nth-child(2n) {
        background-color: #DDDDDD;
    }

    .el-carousel__item:nth-child(2n+1) {
        background-color: antiquewhite;
    }
</style>
