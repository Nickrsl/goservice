
const firebaseConfig = {
  apiKey: "AIzaSyD-WxGLOu3TQkejdv7FCHhVmXHX63dbzb8",
  authDomain: "goservice-firebase.firebaseapp.com",
  projectId: "goservice-firebase",
  storageBucket: "goservice-firebase.appspot.com",
  messagingSenderId: "387552435913",
  appId: "1:387552435913:web:f1e36f1459e17a40aff718",
  measurementId: "G-5D3NDXDCBB"
};


const app = firebase.initializeApp(firebaseConfig);
const storage = firebase.storage();


const progresso = document.querySelector(".progresso");

const fileData = document.querySelector(".filedata");
const urlimagem = document.querySelector("#urlImagem")
let file;
let fileName;
let uploadedFileName;

progresso.style.display = "none";
const getImageData = (e) => {
    file = e.target.files[0];
    fileName = Date.now() + file.name;
    if (fileName) {
        fileData.style.display = "block";
    }
    fileData.innerHTML = fileName;
    console.log(file, fileName);
};

    function showSpinner(flag = true){
        if (flag) {
            progresso.style.display = "block";

        } else {
           progresso.style.display = "none";
        }
    }
const uploadImage = () => {
    showSpinner();
    const storageRef = storage.ref().child("profilePics");
    const folderRef = storageRef.child(fileName);
    const uploadtask = folderRef.put(file);
    uploadtask.on(
        "state_changed",
        (snapshot) => {
            console.log("Snapshot", snapshot.ref.name);
            uploadedFileName = snapshot.ref.name;
        },
        (error) => {
            console.log(error);
        },
        () => {
            storage
                .ref("profilePics")
                .child(uploadedFileName)
                .getDownloadURL()
                .then((url) => {
                    showSpinner(false);
                    console.log("URL", url);
                    urlimagem.setAttribute("value", url);
                });
            console.log("File Uploaded Successfully");
        }
    );
};



(() => {
  'use strict'

  const forms = document.querySelectorAll('.needs-validation')

  Array.from(forms).forEach(form => {
    form.addEventListener('submit', event => {
      if (!form.checkValidity()) {
        event.preventDefault()
        event.stopPropagation()
      }

      form.classList.add('was-validated')
    }, false)
  })
})()