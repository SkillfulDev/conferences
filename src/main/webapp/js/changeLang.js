import {langArr} from './lang.js';


        // pick the element
        const select = document.querySelector('select');

        const allLang = ['en', 'ua'];     

        // registering listener
        select.addEventListener('change', changeURLLanguage);

        // add to URL mark hash
        function changeURLLanguage() {
            let lang = select.value;
            location.href = window.location.pathname + '#' + lang
            location.reload();
            
        }
        // take right hash for change lang
        function changeLanguage() {
            let hash = window.location.hash
            hash = hash.substr(1);
            if (!allLang.includes(hash)) {
                location.href = window.location.pathname + '#en'
                location.reload();
            }
            select.value = hash
            document.getElementById('btn-edit').innerHTML = langArr['btn-edit'][hash]
            document.getElementById('btn-logout').innerHTML = langArr['btn-logout'][hash]

            if (document.getElementById('btn-edit-event')) {
                document.getElementById('btn-edit-event').innerHTML = langArr['btn-edit-event'][hash]
            }

            document.getElementById('btn-speaker').innerHTML = langArr['btn-speaker'][hash]
            document.getElementById('btn-join').innerHTML = langArr['btn-join'][hash]
            document.getElementById('btn-add-event').innerHTML = langArr['btn-add-event'][hash]
        }

        changeLanguage()
        console.log(langArr)

