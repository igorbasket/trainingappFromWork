<template>
    <div class="container" id="vue-app">
        <div class="row">
            <div class="col-sm-12">
                <h1>My Todos {{todoCount}}</h1>

                <ul class="list-group" v-if="todos.length > 0">
                    <li class="list-group-item"
                        v-bind:class="{ 'completed' : todo.completed }"
                        v-for="todo in todos"
                        :key="todo.id">
                        {{todo.title}}
                        :
                        {{todo.time + ' seconds'}}
                        <button class="btn btn-warning btn-xs pull-right" v-on:click="deleteTodo(todo)">Delete</button>
                        <button class="btn btn-xs pull-right margin-right-10"
                                v-bind:class="{'btn-success' : todo.completed, 'btn-danger' : !todo.completed}"
                                v-on:click="todoCompleted(todo)">{{todo.completed ? 'Completed' : 'Pending'}}</button>
                    </li>
                </ul>

                <div v-else><p>You don't have any Todos</p></div>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-12">
                <form v-on:submit.prevent="addNewTodo(newTodo)">
                    <div class="form-group">
                        <input
                                type="text"
                                v-model="newTodo.title"
                                class="form-control"
                                placeholder="Add a new Todo">
                        <input
                                type="text"
                                v-model="newTodo.time"
                                class="form-control"
                                placeholder="Add a new Todo">
                    </div>

                    <div class="form-group">
                        <button class="btn btn-success"
                        >Add Todo</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "CreateNewTraining",
        el: '#vue-app',
        data() {
            return {
                todos: [{id: 1, title: 'Exercise 1', time: 80, completed: false}],
                newTodo: {id: null, title: '', completed: false}
            }
            },

        computed: {
            todoCount() {
                return this.todos.length
            }
        },

        methods: {
            addNewTodo(newTodo) {
                this.todos.push(newTodo)
                this.newTodo = {id: null, title: '', time: null, completed: false}
            },

            deleteTodo(todo) {
                let index = this.todos.indexOf(todo);
                if (index !== -1) {
                    this.todos.splice(index, 1);
                }
            },

            todoCompleted(todo) {
                todo.completed = !todo.completed
            },
            post: function () {
                this.$http.post('/api/training/newTraining',{
                    name: 'TRAIN1',
                    email: 'loha@gmail.com',
                    listExerciseDto: []
                }).then(response => {
                    let a = response.data;
                    alert(a);
                    this.$router.push('/')
                })
            },
        }
    }
</script>

<style scoped>
    li.completed {
        text-decoration: line-through;
    }
    .margin-right-10 {
        margin-right: 10px;
    }
</style>