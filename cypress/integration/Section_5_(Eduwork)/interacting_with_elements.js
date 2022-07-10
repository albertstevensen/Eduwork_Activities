/// <reference types ="cypress"/>

describe('Interacting With Element Section', () =>{
    it('Should load Zero Bank website', () =>{
        cy.visit('http://zero.webappsecurity.com/login.html', {timeout: 10000})
        cy.url().should('include', 'login.html')
    });

    it('should fill username field', () =>{
        cy.get('#user_login').clear()
        cy.get('#user_login').type('username')
    });

    it('should fill password field', ()=>{
        cy.get('#user_password').clear()
        cy.get('#user_password').type('password')
    });

    it('should check the checkbox', () =>{
        cy.get('#user_remember_me').click()
    });
});