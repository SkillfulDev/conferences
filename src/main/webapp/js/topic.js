const button = document.getElementById("topic-btn");
const input_box = document.getElementById("topic-main");

button.addEventListener(
    "click",
    () => {
        const input = document.createElement("input");
        input.name = "topic";
        input.type = "text";
        addNewTopicField(input);
    },
    false
);

function addNewTopicField(input) {
    // console.log(button);
    // console.log(input_box);
    input_box.append(input);
}