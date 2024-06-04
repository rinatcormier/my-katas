const object = {

    someValue: 1,

    get value() {
        return this.someValue;
    },

    set value(v) {
        this.someValue = v;
    },

    myMethod() {
        return Math.pow(this.someValue, this.someValue);
    },
};

console.log(`object value = ${object.value}`); // use getter

object.value = 2; // use setter
console.log(`object value = ${object.value}`);

console.log(`result = ${object.myMethod()}`);
