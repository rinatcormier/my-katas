'use strict';

const sam = Object.freeze({name: 'Sam', age: 21, email: 'example@example.com'});

console.log('This is Sam:');
console.log(sam);

console.log('---------------');

const elderSame = Object.freeze({...sam, age: sam.age + 5});

console.log('This is elder Sam:');
console.log(elderSame);
