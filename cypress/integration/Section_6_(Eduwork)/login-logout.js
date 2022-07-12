/// <reference types="cypress" />

describe('Assertion Login and Logout', () =>{
    before(() =>{
        cy.visit('http://zero.webappsecurity.com/index.html')
        cy.url().should('include', 'index.html')
        cy.get('#signin_button').click()
    });

    it('should try to login with invalid data', () =>{
        cy.get('#user_login').should('be.visible')
        cy.get('#user_login').type('albert2424')

        cy.get('#user_password').should('be.visible')
        cy.get('#user_password').type('albert2424')

        cy.get('input[name="submit"]').click()
    });

    it('should display error message', () =>{
        cy.get('.alert-error').should('be.visible').and('contain.text', 'Login and/or password are wrong.')
    });
    
    it('should try to login with valid data', () =>{
        cy.fixture("zeroWeb").then(zeroWeb =>{
            const username = zeroWeb.username
            const password = zeroWeb.password

            cy.get('#user_login').clear()
            cy.get('#user_login').type(username)

            cy.get('#user_password').clear()
            cy.get('#user_password').type(password)

            cy.get('input[name="submit"]').click()

            cy.url().should('include', 'account-summary.html')
            cy.get('.brand').should('contain.text', 'Zero Bank')
        })
    });

    it('should logout from zero bank', () =>{
        cy.get('.dropdown-toggle').contains('username').click()
        cy.get('#logout_link').should('contain.text', 'Logout')
        cy.get('#logout_link').click()
        cy.url().should('include', 'index.html')
        cy.get('.brand').should('contain.text', 'Zero Bank')
    });
    
});