<template>
    <div align="center">
        <i style="font-size: large">Creating a training:</i>
        <h1/>
    <el-form :model="newTrainingForm" ref="newTrainingForm" class="demo-dynamic" style="width: 400px" >
        <el-form-item label="Training name"
                      :rules="{required: true, message: 'Exercise can not be null', trigger: 'blur'}">
            <el-input v-model="newTrainingForm.name"/>
        </el-form-item>

        <el-form-item label="Input rest duration">
<!--        <strong>Rest duration</strong>-->
        <el-input type="number" min="0" class="inputEx" v-model="valueMinutesRest" style="width: 80px"/>
        <span class="mid" id="middlee">:</span>
        <el-input type="number" min="0" class="inputEx" v-model="valueSecondsRest" style="width: 80px"/>
        </el-form-item>


        <el-form-item
                v-for="(domain, index) in newTrainingForm.listExercise"
                :key="domain.key"
                :rules="{
      required: true, message: 'Exercise can not be empty', trigger: 'blur'
    }"
        >
            <strong>Exercise {{index + 1}}</strong>
            <el-input class="inputEx" placeholder="Input exercise name" v-model="domain.name"/>
            <el-input type="textarea" placeholder="Input exercise description" v-model="domain.description"/>

<!--            <el-time-picker placeholder="Pick exercise duration" v-model="domain.timeEx" style="width: 100%;"/>-->
            <div class="selectArea">
                <el-input type="number" min="0" class="inputEx" v-model="domain.valueMinutes" style="width: 80px"/>
            <span class="mid" id="middle">:</span>
                <el-input type="number" min="0" class="inputEx" v-model="domain.valueSeconds" style="width: 80px"/>
            </div>

<!--            <el-input type="time" v-model="domain.timeEx"></el-input>-->
            <el-button class="del" type="danger" @click.prevent="removeDomain(domain)">Delete</el-button>
        </el-form-item>

        <el-form-item>
            <el-button v-bind="createTrain" type="success" @click="submitForm('newTrainingForm')">Creat</el-button>
            <el-button v-bind="createTrain" type="primary" @click="addDomain('newTrainingForm')">New exercise</el-button>
            <el-button @click="resetForm('newTrainingForm')">Reset</el-button>
        </el-form-item>
        <small class="tet-muted">Data: {{this.newTrainingForm.listExercise}}</small>
    </el-form>


    </div>
</template>


<script>

    export default {
        name: "NewTraining",
        methods: {
            submitForm(formName) {
               // let sum = (this.newTrainingForm.listExercise.valueMinutes * 60) + this.newTrainingForm.listExercise.valueSeconds

               // let add = {name: this.newTrainingForm.listExercise.name,
                //    description: this.newTrainingForm.listExercise.description,
                //    time: 0}

                this.listExerciseDto.push({name: this.newTrainingForm.listExercise.name, description: this.newTrainingForm.listExercise.description, time: 0})


                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        this.$http.post('/api/training/newTraining',{
                            name: this.newTrainingForm.name,
                            email: this.newTrainingForm.email,
                            listExerciseDto: this.newTrainingForm,
                        }).then(response => {
                            let a = response.data;
                            alert(a);
                        })
                        alert('submit!');
                    } else {
                        alert('error submit!!');
                        return false;
                    }
                });

            },
            // resetForm() {
            //     this.newTrainingForm.listExerciseDto.timeEx = 0;
            //     this.newTrainingForm.listExerciseDto.nameEx = '';
            //     this.newTrainingForm.name = '';
            // },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            },
            removeDomain(item) {
                let index = this.newTrainingForm.listExercise.indexOf(item);
                if (index !== -1) {
                    this.newTrainingForm.listExercise.splice(index, 1);
                }
                this.index--
            },
            addDomain() {
                this.index++
                this.newTrainingForm.listExercise.push({
                    name: '',
                    description: '',
                    valueMinutes: 0,
                    valueSeconds: 0,
                });
            },
            createTrain(){





                let sum = (this.newTrainingForm.listExercise.valueMinutes * 60) + this.newTrainingForm.listExercise.valueSeconds


                let add = {name: this.newTrainingForm.listExercise.name,
                    description: this.newTrainingForm.listExercise.description,
                    time: sum}

                this.listExerciseDto.push(add)
            },
            exerciseCount () {
                this.counterEx = 1
            }
        },
        computed:{
            sum() {
                return this.newTrainingForm.listExercise.valueMinutes * 60
            }

             // sum(){


             //     let sum = 0
             //     let minutes = this.valueMinutes * 60
             //     let seconds = this.valueSeconds
             //
             //     sum = minutes + seconds
             //     // this.newTrainingForm.listExerciseDto[this.index].timeEx
             //    return sum
             //
             // },

        },
        data() {
            return {
                newTrainingForm: {
                    name: '',
                    email: 'igorbasket@gmail.com',
                    listExercise: [{
                        name: '',
                        description: '',
                        valueMinutes: 0,
                        valueSeconds: 0,
                    }]
                },
                listExerciseDto: [],
                time: 0,
                valueMinutesRest: 0,
                valueSecondsRest: 0,
                index: 0,

            };
        },

    }
</script>

<style scoped>

    .del{
        margin-top: 1rem;
    }

    .mid{
        font-weight: bolder;
    }
    strong{
        color: rgba(12,12,12,0.68);
        float: left
    }

    .inputEx{
        margin-bottom: 10px;
    }
    .selectArea{
        margin-top: 10px;
    }

</style>