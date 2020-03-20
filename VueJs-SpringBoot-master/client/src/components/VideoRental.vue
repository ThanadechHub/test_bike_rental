<template>
  <v-container>
    <v-layout text-center wrap>
      <v-flex mb-4>
        <br />
        <h1 class="display-2 font-weight-bold mb-3">Welcome to  BigbikeRental</h1>
      </v-flex>
    </v-layout>

    <v-row justify="center">
      <v-col cols="4">
        <v-form v-model="valid" ref="form">
          

               <v-row>
                 <v-col cols="10">
                    <v-text-field
                                  class="font"
                                  outlined
                                  label="รหัสบัตรประจำตัวประชาชน"
                                  v-model="Register.nationalID"
                                  :rules="[(v) => !!v || 'กรุณากรอกรหัสบัตรประชาชน 13 หลัก']"
                                  required
                    ></v-text-field>
                 </v-col>
               </v-row>



              
              <v-row>
                 <v-col cols="10">
                    <v-text-field
                                  class="font"
                                  outlined
                                  label="ชื่อ-นามสกุล"
                                  v-model="Register.name"
                                  :rules="[(v) => !!v || 'กรุณากรอกชื่อ - นามสกุล']"
                                  required
                    ></v-text-field>
                 </v-col>
              </v-row>

            <v-row>
              <v-col cols="10">
                <v-select
                  label="Gender"
                  outlined
                  v-model="Register.gender"
                  :items="genders"
                  item-text="name"
                  item-value="id"
                  :rules="[(v) => !!v || 'Item is required']"
                  required
                ></v-select>
              </v-col>
            </v-row>



            <v-row>
              <v-col cols="10">
                <v-select
                  label="What you'r bike to rent"
                  outlined
                  v-model="Register.bike"
                  :items="bikes"
                  item-text="title"
                  item-value="id"
                  :rules="[(v) => !!v || 'Item is required']"
                  required
                ></v-select>
              </v-col>
            </v-row>

            
           <div v-if = "Register.bike == 1">
                      <v-row justify="center">
                               <v-col cols="50">
                                 
                                  <img id="myImg" src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSMZ023dKt2GWKAlcJsjgisV-j1P1BuWDSjTtWoLG8cwgF5CI8z" 
                                  width="500" height="333">
                                
                               </v-col>
                      </v-row>
           </div>

            <div v-if = "Register.bike >= 1">
                
                    <v-row justify="center">
                              <v-date-picker
                                      v-model="date"
                                      full-width
                                      :landscape="$vuetify.breakpoint.smAndUp"
                                      class="mt-4"
                                    ></v-date-picker>
                    </v-row>
                
            </div>

            <v-row justify="center">
              <v-col cols="12">
                <v-btn @click="saveVideoRental" :class="{ red: !valid, green: valid }">submit</v-btn>
                <v-btn style="margin-left: 15px;" @click="clear">clear</v-btn>
              </v-col>
            </v-row>
            <br />
      
              </v-form>
            </v-col>
    </v-row>
  </v-container>
</template>

<script>
import http from "../http-common";

export default {
  name: "Register",
  data() {
    return {
      Register: {
        nationalID : "",
        name:"",
        gender : "",
        bike:""
      },
      valid: false,
      genders:[],
      bikes:[],
      dialog : false ,
      dialog2 : false 
    };
  },
  methods: {
    /* eslint-disable no-console */

    // ดึงข้อมูล Employee ใส่ combobox
    getGender() {
      http
        .get("/gender")
        .then(response => {
          this.genders = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    
    },
    getBikes() {
      http
        .get("/bike")
        .then(response => {
          this.bikes = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
   myFunction() {
  var x = document.getElementById("myImg").src;
  document.getElementById("demo").innerHTML = x;
},
    // function เมื่อกดปุ่ม submit
    saveVideoRental() {
    http
                .post(
                        "/registerPost",
                        this.Register
                )
                .then(response => {
                  console.log(response);
                  if(response.data != null){
                  
                     
                        this.$router.push("/view");
                  }
                  else {
                    const options1 = { title: "ประกาศ!", size: "sm" };
                        this.$dialogs.alert("บันทึกข้อมูลไม่สำเร็จ", options1);
                  }
                  this.clear();
                })
                .catch(e => {
                  console.log(e);
                  {
                    const options1 = { title: "ประกาศ!", size: "sm" };
                        this.$dialogs.alert("บันทึกข้อมูลไม่สำเร็จ", options1);
                  }
                });
        console.log(this.Register);
        http
                .get("/register")
                .then(response => {
                  this.items = response.data;
                  console.log(this.items);
                  
                })
                .catch(e => {
                  console.log(e);
                });
        this.submitted = true;
    },
    clear() {
      this.$refs.form.reset();
      this.customerCheck = false;
    },
    refreshList() {
        this.getGender();
        this.getBikes();
      // this.getEmployees();
      // this.getVideos();
      // this.getRentalTypes();
    }
    /* eslint-enable no-console */
  },
  mounted() {
    // this.getEmployees();
    // this.getVideos();
    // this.getRentalTypes();
    this.getGender();
    this.getBikes();
  }
};
</script>
<style>
.img{
      image-orientation: url(C:\VueJs-SpringBoot-master\images\69460375_2580825495478026_7538393535557402624_n.jpg);
}

</style>