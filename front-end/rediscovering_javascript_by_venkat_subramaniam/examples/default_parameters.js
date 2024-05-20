const greeting = function (message, name = `John Doe ${message.length} times`) {
    return `${message} ${name}`;
}

console.log(greeting('Hello', 'Sonya'));
console.log(greeting('Howdy'));
